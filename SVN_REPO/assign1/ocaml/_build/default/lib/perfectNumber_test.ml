let%test "Canary test" = true

let%test "Add two numbers" = Sample.add 1 2 == 3

let%test "Multiply two numbers" = Sample.multiply 4 5 == 20 