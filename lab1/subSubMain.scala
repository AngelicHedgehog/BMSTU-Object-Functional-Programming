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

val maxSeqBySum: List[Int] => (Int, Int) = {
    def maxSeqBySumWithSum: List[Int] => (Int, Int, Int) = {
        case Nil                    => (0, 0, 0)
        case (x :: xs) if (x < 0)   =>
            maxSeqBySumWithSum(xs) match {
                case (0, 0, 0)      => (0, 0, 0)
                case (a, b, sum)    => (a + 1, b + 1, sum)
            }
        case (x :: Nil)             => (0, 1, x)
        case (x :: y :: tail)       =>
            maxSeqBySumWithSum((x + y) :: tail) match {
                case (0, b, sum) if (sum > x)   => (0, b + 1, sum)
                case (0, _, _)                => (0, 1, x)
                case (a, b, sum) if (sum > x)   => (a + 1, b + 1, sum)
                case (_, _, _)                  => (0, 1, x)
            }
    }
    xs => maxSeqBySumWithSum(xs) match {
        case (a, b, sum) => (a, b)
    }
}

// https://site.ada.edu.az/~medv/acm/Docs%20e-olimp/Volume%2026/2585.htm
val test1 = List(-3, 4, 9, -2, -5, 8, -3)
println(maxSumKadan(test1)) // 14
println(maxSeqBySum(test1)) // 1 6

val test2 = List(5, -3, 1, -7, 4, -2, 4, -1, -8, 2)
println(maxSumKadan(test2)) // 6
println(maxSeqBySum(test2)) // 4 7

val test3 = List(-1, 10, -1, -1, -1, 10, -1, -1, -1, 10)
println(maxSumKadan(test3)) // 24
println(maxSeqBySum(test3)) // 1 10
