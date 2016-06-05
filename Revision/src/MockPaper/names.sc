def all_except_option(s: String, list: List[String]): Option[List[String]] = {
  list match {
    case Nil => None
    case List() => None
    case hd :: tl => {
      if (hd.equals(s)) Some(tl)
      else {
        all_except_option(s, tl) match {
          case None => None
          case Some(y) => Some(hd::y)
        }
      }
    }
  }
}

def getSubs(subs: List[List[String]], s: String): List[String] = {
  subs match {
    case Nil => List()
    case hd::tl => {
      all_except_option(s,hd) match {
        case None => getSubs(tl, s)
        case Some(y) => y ++ getSubs(tl,s)
      }
    }
  }
}

def getSubs2(subs: List[List[String]],s:String): List[String] = {
  def helper(acc: List[String],subs: List[List[String]]):List[String] = {
    subs match {
      case Nil => acc
      case hd::tl => {
        all_except_option(s,hd) match {
          case None => helper(acc,tl)
          case Some(list) => helper(acc++list, tl)
        }
      }
    }
  }
  helper(List(), subs)
}

type Name = (String, String, String)

def similar_names(subs: List[List[String]], name: Name): List[Name] = {

  def helper(subs: List[String], name: Name): List[Name] = {
    subs match {
      case Nil => List(name)
      case hd::tl => (hd,name._2,name._3) :: helper(tl,name)
    }
  }

  helper(getSubs2(subs,name._1), name)
}


