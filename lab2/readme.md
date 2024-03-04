% Лабораторная работа № 2 «Введение в 
  объектно-ориентированное программирование
  на языке Scala»
% 4 марта 2024 г.
% Сергей Виленский, ИУ9-62Б

# Цель работы
Целью данной работы является изучение базовых
объектно-ориентированных возможностей языка Scala.

# Индивидуальный вариант
Целочисленный вектор в n-мерном пространстве с
операциями сложения, вычитания, скалярного
умножения, умножения на число и обращения
(унарный минус).

# Реализация и тестирование

```scala
class MyVector( private val _vect: Vector[Int] ) {

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

implicit class MyVectorFactor( x: Int ) {
    def * ( v: MyVector ) = v * x
}

val vect1 = new MyVector(1, 2, 3)
val vect2 = new MyVector(4, 5, 6)
println(vect1 + vect2)  // (5, 7, 9)
println(vect1 - vect2)  // (-3, -3, -3)
println(vect1 * vect2)  // 1*4 + 2*5 + 3*6 = 4 + 10 + 18 = 32
println(vect1 * 3)      // (3, 6, 9)
println(2 * vect2)      // (8, 10, 12)
```

# Вывод
В результате выполнения данной работы были
изучены базовые объектно-ориентированные
возможности языка Scala.
