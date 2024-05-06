//Server

if (process.env.NODE_ENV !== 'production') {
    require('dotenv').config();
  }
//const host = 'localhost';
const port = 8000;

const express = require('express');
const bodyParser = require("body-parser");
const cors = require('cors');
var ethers = require('ethers');
const router = express.Router();
var app = express();
app.use(cors());
// Using express.urlencoded middleware
app.use(express.urlencoded({
    extended: true
}))
// add router in the Express app.
app.use("/", router);

router.get('/', async function (req, res) {
    res.send('Hello GTS!')
});

router.post('/addCoupon', async function (req, res) {
    console.log("hitting server-addcoupon");
    var startdate = new Date(req.body.startdate);
    var stopdate = new Date(req.body.stopdate);
    var coupon = req.body.coupon;
    var discount = req.body.discount;
    console.log("Start Date"+startdate);
    console.log("Stop Date"+stopdate);
    const startdateInSecs = Math.floor(startdate.getTime() / 1000);
    const stopdateInSecs = Math.floor(stopdate.getTime() / 1000);

    try
    {
        const addcoupon = await coupDetailsContract.addCoupon(coupon,startdateInSecs,stopdateInSecs,discount);
        const receipt = await addcoupon.wait();
        console.log("Transaction hash: " + addcoupon.hash);
        res.send(addcoupon.hash);
    }
    catch (error)
    {
        console.log("Transaction error: " + error);
        res.send(error);
    }
});

router.post('/getCoupon', async function (req, res) {
    // res.send('<b>Hello</b> welcome to my http server made with express');
     console.log("hitting server-getcoupon");
     var coupon = req.body.coupon;
     var getreqdate=new Date();
     const getdateInSecs = Math.floor(getreqdate.getTime() / 1000);
     console.log("hitting server-getcoupon"+getdateInSecs);
     try{const getcoupon = await coupDetailsContract.getCoupon(coupon,getdateInSecs);
     console.log("Coupon Status: " + getcoupon);
     res.send(getcoupon);
     }
     catch (error)
     {
         console.log("Transaction error: " + error);
         res.send(error);
     } 
     
 });

 router.post('/addUsedCoupon', async function (req, res) {
    // res.send('<b>Hello</b> welcome to my http server made with express');
    //console.log("hitting server-addUsedcoupon");
     
     var coupon = req.body.coupon;
     console.log("hitting server-addusedcoupon"+coupon);
     try{
        const addcoupon = await coupDetailsContract.addUsedCoupon(coupon);
        const receipt = await addcoupon.wait();
        console.log("Transaction hash: " + addcoupon.hash);
        res.send(addcoupon.hash);
     }
     catch (error)
     {
         console.log("Transaction error: " + error);
         res.send(error);
     } 
     
 });

 router.post('/verifyUsedCoupon', async function (req, res) {
    // res.send('<b>Hello</b> welcome to my http server made with express');
    //console.log("hitting server-verifyUsedcoupon");
     
     var coupon = req.body.coupon;
     console.log("hitting server-verifyUsedcoupon"+coupon);
     try{const getcoupon = await coupDetailsContract.verifyUsedCoupon(coupon);
     console.log("Coupon Status: " + getcoupon);
     res.send(getcoupon);
     }
     catch (error)
     {
         console.log("Transaction error: " + error);
         res.send(error);
     } 
     
 });

    const contract = require("../build/contracts/Ecoupon.json");
    //LOCAL ENABLE THIS AND DISABLE Ethereum-goerli------------------------
    const PRIVATE_KEY = process.env.PRIVATE_KEY_LOCAL;
    const CONTRACT_ADDRESS = process.env.CONTRACT_ADDRESS_LOCAL;
    // provider - JSON Provider 
    const etherProvider = new ethers.providers.JsonRpcProvider("http://127.0.0.1:8545");
    // signer - you with the private key
    const signer = new ethers.Wallet(PRIVATE_KEY, etherProvider);
     
    console.log("private key"+PRIVATE_KEY);
    // contract instance
    const coupDetailsContract = new ethers.Contract(CONTRACT_ADDRESS, contract.abi, signer);

// start the server in the port 8000 !
app.listen(port, () =>{
    console.log('Example app listening on port 8000.');
});





