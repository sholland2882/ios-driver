/*
 * Copyright 2012-2013 eBay Software Foundation and ios-driver committers
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.uiautomation.ios.server.application;

import org.json.JSONArray;
import org.json.JSONObject;
import org.uiautomation.ios.IOSCapabilities;
import org.uiautomation.ios.communication.device.DeviceType;
import org.uiautomation.ios.server.Device;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class IPAShellApplication extends IPAApplication {


  private final String bundleId;
  private final String version;

  public IPAShellApplication(String bundleId, String version) {
    super(null, null);
    this.version = version;
    this.bundleId = bundleId;

  }

  protected IPAShellApplication(File ipa, String pathToApp) {
    super(ipa, pathToApp);

    bundleId = null;
    version = null;
  }

  @Override
  public String getBundleId() {
    return bundleId;
  }

  @Override
  public String getBundleVersion() {
    return version;
  }

  @Override
  public List<String> getSupportedLanguagesCodes() {
    return new ArrayList<>();
  }

  @Override
  public IOSCapabilities getCapabilities() {
    IOSCapabilities res =  IOSCapabilities.iphone("Safari");
    res.setBundleId(bundleId);
    res.setBundleName("Safari");
    res.setSupportedLanguages(getSupportedLanguagesCodes());
    res.setCapability(IOSCapabilities.SUPPORTED_DEVICES,new JSONArray().put(DeviceType.iphone));
    res.setCapability(IOSCapabilities.SIMULATOR, false);

    return res;
  }

  @Override
  public String toString(){
    return bundleId +"::"+ version;
  }
  @Override
  public boolean isSimulator(){
    return false;
  }

  @Override
  public JSONObject getMetadata(){
    return new JSONObject();
  }
}
