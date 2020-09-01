package rhobbs;

import rhobbs.model.GuitarHero;
import rhobbs.model.Hero;
import rhobbs.model.HeroFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class SwingyTests{
  private static Validator validator;

  SwingyTests(int testIndex) {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();

    Hero hero = HeroFactory.buildHero("Frank", "Guitar Hero");

    switch (testIndex) {
      case 0:
        hero = new GuitarHero(
                "     ",
                "",
                "",
                "",
                0,
                -1,
                -1
        );
      default:
        break;
    }

//    hero = null;
    try {
      hero.validateHero();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }


//    Set<ConstraintViolation<Hero>> cvs = validator.validate(hero);
//
//    for (ConstraintViolation<Hero> cv : cvs) {
//      System.out.println(cv.getPropertyPath() + ": " + cv.getMessage());
//    }
  }
}

//public class SwingyTests {
//
//}
