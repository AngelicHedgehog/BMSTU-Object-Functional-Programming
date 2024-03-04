class MyVector( vect: Vector[Int] ) {
    private var _vect = vect

    def this ( init_list: Int* ) = this(init_list.toVector)

    override def toString: String = s"My${_vect.toString}"

    def unary_- =
        new MyVector(_vect.map(-_))

    def + ( other_v: MyVector ) =
        new MyVector(Vector(_vect, other_v._vect).transpose.map(_.sum))

    def - ( other_v: MyVector ) =
        this + -other_v
    
    def * ( other_v: MyVector ) =
        Vector(_vect, other_v._vect).transpose.map(x => x(0) * x(1)).sum

    def * ( scalar: Int ) =
        new MyVector(_vect.map(_ * scalar))
}

val vect1 = new MyVector(1, 2, 3)
val vect2 = new MyVector(4, 5, 6)
println(vect1 + vect2)  // (5, 7, 9)
println(vect1 - vect2)  // (-3, -3, -3)
println(vect1 * vect2)  // 1*4 + 2*5 + 3*6 = 4 + 10 + 18 = 32
println(vect1 * 3)      // (3, 6, 9)
