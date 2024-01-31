fn main() {
    let strawberry: (&str, bool, i32) = ("Strawberry", true, 5);
    println!("Fruit: {}, Available: {}, Quantity: {}", strawberry.0, strawberry.1, strawberry.2);

    let pineapple: (&str, &str, i32) = ("Pineapple", "Yellow", 3);
    println!("Fruit: {}, Color: {}, Quantity: {}", pineapple.0, pineapple.1, pineapple.2);
}