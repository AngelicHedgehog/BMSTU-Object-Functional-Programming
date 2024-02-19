val partitionP: (List[Int], Int => Boolean) => (List[Int], List[Int]) = {
    case (Nil, f)       ⇒ (Nil, Nil)
    case (x :: xs, f)   ⇒
        partitionP(xs, f) match {
            case (as, bs) if (f(x)) ⇒ (x :: as, bs)
            case (as, bs)           ⇒ (as, x :: bs)
        }
}

println(partitionP(List(0, 0, 1, -2, -5, 10, -3, 0, 1, -10, 1, -2), _ % 2 == 0))
