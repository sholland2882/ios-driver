package org.uiautomation.ios.grid;

import org.openqa.grid.selenium.GridLauncher;

public class Hub {

  public static void main(String[] args) throws Exception {
    String[] a = {
        "-port", "4444",
        "-host","localhost",
        "-role", "hub",
        "-capabilityMatcher","org.uiautomation.ios.grid.IOSCapabilityMatcher,org.uiautomation.ios.grid.WebCapabilityMatcher"
    };
    GridLauncher.main(a);
  }
}