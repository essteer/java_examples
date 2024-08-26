console.log('this is a script file')

const name = "Bob"

let x = 7
x = 'hi'  // not typed
console.log(x)

let y = 8
y = 9

let numbers = [1,3,5]
let person = {name:"Ryan"}
console.log(person[name])
console.log(person.name)

let age = 5
if (age === 5) {
    console.log("Is a 5-year-old")
}

for (let i=99; i<10; i--) {
    console.log("There are " + i + " bottles of milk on the wall")
}

for (let num in numbers) {
    console.log(num)  // prints the element index
}

for (let num of numbers) {
    console.log(num)  // prints the element
}

function product (a,b) {
    return a*b;
}
console.log(product(2,3))

const product2 = (a,b) => a*b;

const product3 = (a,b) => {
    return a*b;
}