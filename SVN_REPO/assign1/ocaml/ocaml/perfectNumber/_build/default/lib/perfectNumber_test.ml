open PerfectNumber

let test_perfect_number_imperative () =
  let test_cases = [6; 28; 496; 8128] in
  List.iter (fun number ->
    let result = PerfectNumber.is_perfect_number_imperative number in
    assert (result = true)
  ) test_cases

let test_non_perfect_number_imperative () =
  let non_perfect_numbers = [78; 48; 1234; 8; 20; 9; 11] in
  List.iter (fun number ->
    let result = PerfectNumber.is_perfect_number_imperative number in
    assert (result = false)
  ) non_perfect_numbers

let test_number_less_than_or_equal_to_1_imperative () =
  let test_cases = [0; 1; -1; -100] in
  List.iter (fun number ->
    let result = PerfectNumber.is_perfect_number_imperative number in
    assert (result = false)
  ) test_cases

  let () =
  test_perfect_number_imperative ();
  test_non_perfect_number_imperative ();
  test_number_less_than_or_equal_to_1_imperative ()
