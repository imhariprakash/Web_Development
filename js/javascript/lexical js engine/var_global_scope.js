function a(){
    console.log(myvar);
}

function b(){
    a();
    var myvar = 2;
    a();
}

var myvar = 1;
b();