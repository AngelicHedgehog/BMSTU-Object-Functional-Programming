val sublists: (List[Int], Int) ⇒ List[List[Int]] = {
    case (Nil, p) if (0 <= p)       ⇒ List(Nil)
    case (Nil, _)                   ⇒ Nil
    case (x :: xs, p) if (x <= p)   ⇒ List(x) :: sublists(xs, p)
    case (x :: Nil, p)              ⇒ sublists(Nil, p)
    case (x :: y :: xs, p)          ⇒
        sublists((x + y) :: xs, p) match {
            case (Nil) | (Nil :: Nil)   ⇒ Nil
            case (Nil :: _)             ⇒ Nil // невалидный случай
            case ((aa :: aas) :: as)    ⇒ (x :: (aa - x) :: aas) :: as
        }
}

println(sublists(List(0, 0, 1, -2, -5, 10, -3, 0, 1, -10, 1, -2), 0))
