function a(){
    function b(){
        console.log(myvar);
    }
    var myvar = 2;
    b();
}
var myvar = 1;
a();
//b();

// if var myvar = 2; is commented then look deep down : and finds 1