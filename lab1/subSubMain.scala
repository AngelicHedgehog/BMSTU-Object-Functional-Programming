val maxSumKadan: List[Int] => Int = {
    case Nil                    => 0
    case (x :: xs) if (x <= 0)  => maxSumKadan(xs)
    case (x :: Nil)             => x
    case (x :: y :: tail)       =>
        maxSumKadan((x + y) :: tail) match {
            case p if (p > x)   => p
            case p              => x
        }
}

// https://site.ada.edu.az/~medv/acm/Docs%20e-olimp/Volume%2026/2585.htm
println(maxSumKadan(List(-3, 4, 9, -2, -5, 8, -3))) // 14
println(maxSumKadan(List(5, -3, 1, -7, 4, -2, 4, -1, -8, 2))) // 6
