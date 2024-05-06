var ecoupon = artifacts.require("./Ecoupon.sol");

module.exports = function(deployer) {
  deployer.deploy(ecoupon);
};
