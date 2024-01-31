use crate::{fibonacci_iterative, fibonacci_recursive_procedure_process, fibonacci_recursive_iterative};

fn test_fibonacci_function(fibonacci_fn: fn(u32) -> Vec<u32>) {
    assert_eq!(fibonacci_fn(0), vec![1]);
    assert_eq!(fibonacci_fn(1), vec![1, 1]);
    assert_eq!(fibonacci_fn(2), vec![1, 1, 2]);
    assert_eq!(fibonacci_fn(5), vec![1, 1, 2, 3, 5, 8]);
    assert_eq!(fibonacci_fn(10), vec![1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]);
}

#[test]
fn test_fibonacci_iterative() {
    test_fibonacci_function(fibonacci_iterative);
}

#[test]
fn test_fibonacci_recursive_procedure_process() {
    test_fibonacci_function(fibonacci_recursive_procedure_process);
}

#[test]
fn test_fibonacci_recursive_iterative() {
    test_fibonacci_function(|n| fibonacci_recursive_iterative(n, vec![1]));
}


