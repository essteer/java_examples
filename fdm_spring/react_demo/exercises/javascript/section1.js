// Alien colours
const getPoints = (color) => {
    if (color === 'green') {
        return 5
    }
    if (color === 'red') {
        return 10
    }
    if (color === 'yellow') {
        return 15
    }
}

console.log(getPoints('red') + getPoints('yellow'))

// Summing numbers
const sumOfNumbersUpTo = (x) => {
    let result = 0
    for (i=1; i<=x; i++) {
        result = result + i
    }
    return result
}

console.log(sumOfNumbersUpTo(10))

// Valid account numbers
const validAccountNumber = (ac) => {
    let acString = ac.toString()
    if (acString.length == 8) {
        return true;
    }
    return false;
}

// Reversing a string
const reverseString = (string) => {
    let reverse = ''
    for (i=string.length-1; i>=0; i--) {
        reverse = reverse + string[i]
    }
    return reverse
}
console.log(reverseString('lemonade'))

// Fibonacci number
const fibonacciNumber = (x) => {
    let sequence = [0, 1]
    if (x <= 0) {
        return 'Enter a number > 0'
    }
    if (x == 1) {
        return 0
    } else if (x == 2) {
        return 1
    }
    for (i=3; i<=x; i++) {
        let next_num = sequence[sequence.length-2] + sequence[sequence.length-1]
        sequence.push(next_num)
    }
    return sequence[sequence.length-1]
}