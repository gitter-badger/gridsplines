
import org.scalacheck.Prop._
import org.scalacheck._
import piecewise.PieceFunction._

import scala.math._
/**
  * Created by Даниил on 17.02.2017.
  */
object RuleOfHorner extends Properties("Rule of Horner implementation") {

  property("Square Horner coincidence") =
    Prop.forAllNoShrink{ (a0: Double, a1: Double, a2: Double, x: Double) => {
    val genGorner = ruleOfGorner(x, a2, a1, a0)
    val specGorner = quadraticRuleOfHorner(x, a0, a1, a2)
    val accurate = polynomial(x, a2, a1, a0)
    all(
      //abs((genGorner - accurate) / accurate) < 1.00,
      abs((specGorner - accurate) / accurate) < 3.00
    )
  }}

  property("Cubic Horner coincidence") =
    Prop.forAllNoShrink{ (a0: Double, a1: Double, a2: Double, a3: Double, x: Double) => {
    val genGorner = ruleOfGorner(x, a3, a2, a1, a0)
    val specGorner = cubicRuleOfHorner(x, a0, a1, a2, a3)
    val accurate = polynomial(x, a3, a2, a1, a0)
    all(
      //abs((genGorner - accurate) / accurate) < 1.00,
      abs((specGorner - accurate) / accurate) < 3.00
    )
  }}

  property("Quad Horner coincidence") =
    Prop.forAllNoShrink{(a0: Double, a1: Double, a2: Double, a3: Double, a4: Double, x: Double) => {
      val genGorner = ruleOfGorner(x, a4, a3, a2, a1, a0)
      val specGorner = quadRuleOfGorner(x, a0, a1, a2, a3, a4)
      val accurate = polynomial(x, a4, a3, a2, a1, a0)
      all(
        //abs((genGorner - accurate) / accurate) < 1.00,
        abs((specGorner - accurate) / accurate) < 3.00
      )
    }}
}
