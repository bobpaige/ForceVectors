package com.bobman.vectors;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ForceVector {
  private @Getter double radians;
  private @Getter double length;

  public ForceVector add(ForceVector other) {
    double r = Math.sqrt(
        length * length + other.length * other.length + 2 * length * other.length * Math.cos(other.radians - radians));
    double phi = radians + Math.atan2(other.length * Math.sin(other.radians - radians),
        length + other.length * Math.cos(other.radians - radians));
    return ForceVector.builder()
        .radians(phi)
        .length(r)
        .build();
  }

  public ForceVector subtract(ForceVector other) {
    return add(other.reverse());
  }

  public ForceVector reverse() {
    return ForceVector.builder()
        .length(-length)
        .radians(radians)
        .build();
  }
}
