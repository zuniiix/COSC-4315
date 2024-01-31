mod test;

fn fibonacci_iterative(position: u32) -> Vec<u32> {
    (0..position).fold(vec![1], |mut series, _| {
        let next = series.iter().rev().take(2).sum();
        series.push(next);
        series
    })
}


fn fibonacci_recursive_procedure_process(position: u32) -> Vec<u32> {
    match position {
        0 => vec![1],
        1 => vec![1, 1],
        _ => {
            let mut series = fibonacci_recursive_procedure_process(position - 1);
            series.push(series[series.len() - 1] + series[series.len() - 2]);
            series
        }
    }
}



fn fibonacci_recursive_iterative(position: u32, current: Vec<u32>) -> Vec<u32> {
    match position {
        0 => current,
        _ => {
            let next = current.iter().rev().take(2).sum();
            fibonacci_recursive_iterative(position - 1, [current, vec![next]].concat())
        }
    }
}


