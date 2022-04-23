var actualPrice = 1000;
var sellingPrice = 200;
var discount = ((actualPrice - sellingPrice) / actualPrice) * 100;
console.log(Math.round(discount) + "% off");