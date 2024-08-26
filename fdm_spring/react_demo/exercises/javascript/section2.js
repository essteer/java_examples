// Times table
const displayTimesTable = (x) => {
    for (i=1; i<=12; i++) {
        console.log(i + ' x ' + x + ' = ' + i*x)
    }
}

// Print rectangle
const printRectangle = (x,y) => {
    let output = ''
    for (i=1; i<=y; i++) {
        for (j=1; j<=x; j++) {
            output = output + 'X'
        }
        output = output + '\n'
    }
    console.log(output)
}

// Print triangle
const printTriangle = (x) => {
    let output = ''
    for (i=1; i<=x; i++) {
        for (j=1; j<=i; j++) {
            output = output + 'X'
        }
        output = output + '\n'
    }
    console.log(output)
}