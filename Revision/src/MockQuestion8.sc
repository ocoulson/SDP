

def all_except_option(s: String, lst: List[String]):Option[List[String]] = {
  lst match {
    case Nil => None
    case head :: tail =>
      if (head == s) Some(tail)
      else all_except_option(s, tail) match {
        case None => None
        case Some(y) => Some(head :: y)
      }
  }
}

def get_sub1(subs: List[List[String]], s: String): List[String] = {
  subs match {
    case Nil => Nil
    case hd :: tl => {
      all_except_option(s, hd) match {
        case None => get_sub1(tl, s)
        case Some(y) => y++get_sub1(tl,s)
      }
    }
  }
}


def get_sub2(subs: List[List[String]], s: String): List[String] = {
  def helper(acc: List[String], subs: List[List[String]]): List[String] = {
    subs match {
      case Nil => acc
      case hd :: tl =>
          all_except_option(s,hd) match {
            case None => helper(acc, tl)
            case Some(y) => helper(acc ++ y, tl)
          }
    }
  }

  helper(List(), subs)
}


type Name = (String, String, String)

def similar_names(subs: List[List[String]], name: Name): List[Name] = {
  val output: List[Name] = List(name)
  val subNames = get_sub1(subs, name._1).map(s => (s, name._2, name._3))
  output++subNames

}

def similar_names2(subs: List[List[String]], name: Name): List[Name] = {

  def helper(acc: List[Name], subs: List[List[String]], name: Name): List[Name] = {
    subs match {
      case Nil => List(name)++acc
      case hd :: tl => {
        all_except_option(name._1, hd) match {
          case None => helper(acc, tl, name)
          case Some(y) => {
            y.foreach(s => acc ++ List(s, name._2, name._3))
            helper(acc, tl, name)
          }
        }
      }
    }
  }
  helper(List(), subs, name)
}

val subs: List[List[String]] = List(List("Fred","Fredrick"),List("Elizabeth","Betty"),List("Freddie","Fred","F"))
val name: Name = ("Fred", "W", "Smith")
similar_names(subs, name)

similar_names(subs,name)