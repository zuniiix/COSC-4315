open PerfectNumber

let%test "Canary test" = true

let%test "Check if a number is perfect" =
  let perfect_numbers = [6; 28; 496; 8128] in
  List.for_all (fun number -> is_perfect_number_imperative number && is_perfect_number_functional number) perfect_numbers

let%test "Check if a number is non-perfect" =
  let non_perfect_numbers = [8; 15; 22; 100] in
  List.for_all (fun number -> (not (is_perfect_number_imperative number)) && (not (is_perfect_number_functional number))) non_perfect_numbers
  
let%test "Check if a negative number is not perfect" =
  let negative_numbers = [-6; -28; -496; -8128] in
  List.for_all (fun number -> (not (is_perfect_number_imperative number)) && (not (is_perfect_number_functional number))) negative_numbers
