var isLoggedIn = true;
var isVerified = true;
var isCardInfo = true;

if(isLoggedIn && isVerified && isCardInfo) {
    console.log("Welcome to the site!");
}
else{
    if(!isLoggedIn){
        console.log("You need to log in first!");
    }
    else if(!isVerified){
        console.log("You need to verify your account first!");
    }
    else if(!isCardInfo){
        console.log("You need to enter your credit card information first!");
    }
}

isCardInfo ? console.log("Welcome to the siteeee!") : console.log("You need to enter your credit card information first!");