//SPDX-License-Identifier: UNLICENSED
// Solidity program
// to store
// Employee Details
//pragma solidity ^0.6.8;
pragma solidity >=0.7.3;

// Creating a Smart Contract
contract Ecoupon{

// Structure of employee
struct Coupon{
	
// State variables
	string coupid;
	uint startdate;
	uint stopdate;
	string discountamt;
}

Coupon []coups;

//uint deployDate=block.timestamp;

//function Time_call() returns (uint256){
//        return now;
//    }

// Function to add
// employee details
function addCoupon(
	string memory coupid, uint startdate,
	uint stopdate,
	string memory discountamt
    
) public{
	Coupon memory e
		=Coupon(coupid,
				startdate,
				stopdate,
				discountamt);
	coups.push(e);
}

mapping(string => bool) public blacklistedCoupon;

function addUsedCoupon(string memory couponid) public {
    blacklistedCoupon[couponid] = true;
}

//function addUsedCouponid(string memory couponid) internal {
//    blacklistedCoupon[couponid] = true;
//}

function verifyUsedCoupon(string memory couponid) public view returns(bool) {
    bool userIsBlacklisted = blacklistedCoupon[couponid];
    return userIsBlacklisted;
}


// Function to get
// details of Coupon
//uint date_1 = 1638352800; // 2012-12-01 10:00:00
//uint date_2 = 1638871200; // 2012-12-07 10:00:00
function getCoupon(
	string memory coupid,uint getdate
) public view returns(bool,	string memory)
{
	if (blacklistedCoupon[coupid] == true)
	{
		return (false,"Coupon Used");
	}
	//blacklistedCoupon[coupid] = true;
	uint i;
	for(i=0;i<coups.length;i++)
	{
		Coupon memory e
			=coups[i];
		
		// Looks for a matching
		// employee id
		if(keccak256(abi.encodePacked(e.coupid))==keccak256(abi.encodePacked(coupid)))
		{
				if(e.startdate <= getdate)
                {
                if(getdate <= e.stopdate) {					
					return (true,e.discountamt);}
                else {
                return (false,'Not Valid Date');}
                }
                else { return (false,'Not Valid Date');}
             
		}
	}
	
	// If provided employee
	// id is not present
	// it returns Not
	// Found
	return(false,"Not Found");
}
}
