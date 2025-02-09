function sum() {
    console.log(arguments);

    //안됨 -
    return [...arguments].reduce((total, el) => total + el);
}

console.log(sum(1, 2, 3, 4, 5));
