 //assumes all input values are in the range [-2 , 2], where -2 means very low and 2 means very high
 //The safety index is a number quantifying the level of safety that can be expected from an offshoot, in comparison the DGG server has a safety index of 1

    protected void calculateIndex() {
    index = new SafetyIndex();
    double overall = 0.0;

    overall += 3 * getIndexPartPreCalc(level_of_quality);
    overall += getIndexPartPreCalc(new_user_quality);
    overall += getIndexPartPreCalc(worried_harassment);
    overall += getIndexPartPreCalc(worried_called_slur);
    overall += getIndexPartPreCalc(worried_messages_leaked);
    overall += getIndexPartPreCalc(worried_ganged_up);
    overall += getIndexPartPreCalc(worried_skin_ethnic_religion);
    overall += getIndexPartPreCalc(problem_drugs);
    overall += getIndexPartPreCalc(problem_worrying_nsfw);
    overall += getIndexPartPreCalc(problem_doxxing);
    overall += getIndexPartPreCalc(problem_corruption_moderation);

    index.main = overall / 17;
    index.exp = index.main / 2 + ((index.main > 20) ? Math.pow(index.main - 20, 1.65) : 0.0);


  }

  protected double getIndexPartPreCalc(double internalValue) {
    return (internalValue + 2) * 25;
  }