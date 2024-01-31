//Given this JavaScript code:

var employment = { 
  salary: 100,
  bonus: function() {
    this.salary *= 1.2;
  }  
}

class Person {}

const jill = new Person();
const jack = new Person();

Object.setPrototypeOf(jill, employment);
Object.setPrototypeOf(jack, employment);

console.log(Object.getPrototypeOf(jill) === Object.getPrototypeOf(jack)); // true

console.log(jill.salary); // 100
console.log(jack.salary); // 100

jill.bonus();

console.log(jill.salary); // 120
console.log(jack.salary); // 100

//The first console.log shows that both the objects, jill and jack,
//share the prototype. The values for salary for each are the same as well,
//initially. But, when the bonus function sets the salary, it changed only for
//the object jill and not for the object jack. Why is that? Explain.

/*
Jill and Jack are both object copies of the blueprint of employment, which includes properties like 
"salary" and a method called "bonus." In the beginning, both Jill and Jack have their "salary" 
initialized to 100. When the jill.bonus() method is called, it only affects Jill's salary, setting it 
to 120. However, if the line  jill.__proto__.bonus() were used, it would call the "bonus" method on 
the blueprint of Jill, which is derived from the "employment" object. This would set the "salary" 
property to 120 for both Jill and Jack.
*/

Total [10]: -8
Does not address the fact that sets are shallow but gets are deep.
