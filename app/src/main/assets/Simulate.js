function simOneLife(age, sex, life) {
  var curr_age = age;
  var alive = true;
  var probs_index, p;
  while (alive) {
    probs_index = curr_age;
    p = Math.random();
    if (curr_age > 118) {
      p_death = 0.999;
    } else {
      if (sex == "female") {
        var p_death = life[probs_index].female_prob_death;
      } else {
        var p_death = life[probs_index].male_prob_death;
      }
    }
    if (p <= p_death) {
      alive = false;
    }
    if (alive) {
      curr_age++;
    }
  }
  return curr_age;
}
