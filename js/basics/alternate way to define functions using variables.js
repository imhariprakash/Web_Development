var calculate = function (num1, num2, action){
    switch(action){
        case '+':
            return num1 + num2;
            break;
        case '-':
            return num1 - num2;
            break;
        case '*':
            return num1 * num2;
            break;
        case '/':
            return num1 / num2;
            break;
        case '%':
            return num1 % num2;
            break;
    }
}

console.log(calculate(1,2,'+'));
console.log(calculate(1,2,'-'));
console.log(calculate(1,2,'*'));
console.log(calculate(1,2,'/'));
console.log(calculate(1,2,'%'));

