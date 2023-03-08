const m = new Map();

m.set('a', 'b');
m.set(3, 'c');
const myObj = {};
m.set(myObj, 'e');

m.get(myObj);
console.log(m.get(myObj));

m.size;
console.log(m.size)

for (const [k, v] of m) {
    console.log(k, v);
}

m.forEach((v, k) => {
    console.log(k, v);
});

m.has(myObj);
console.log(m.has(myObj));

m.delete(myObj);
m.clear();
console.log(m.size);