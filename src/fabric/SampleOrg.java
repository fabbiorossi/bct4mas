package fabric;

import org.hyperledger.fabric.sdk.User;
import org.hyperledger.fabric_ca.sdk.HFCAClient;

import java.util.*;

/*
 *  Copyright 2016, 2017 DTCC, Fujitsu Australia Software Technology, IBM - All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * Sample Organization Representation
 *
 * Keeps track which resources are defined for the Organization it represents.
 *
 */
public class SampleOrg {
  private final String name;
  private final String mspid;
  private HFCAClient caClient;

  private Map<String, User> userMap = new HashMap<>();
  private Map<String, String> peerLocations = new HashMap<>();
  private Map<String, String> ordererLocations = new HashMap<>();
  private Map<String, String> eventHubLocations = new HashMap<>();
  private UserImplementation admin;
  private String caLocation;
  private Properties caProperties = null;

  private UserImplementation peerAdmin;


  private String domainName;

  public String getCAName() {
    return caName;
  }

  private String caName;

  SampleOrg(String name, String mspid) {
    this.name = name;
    this.mspid = mspid;
  }

  public UserImplementation getAdmin() {
    return admin;
  }

  public void setAdmin(UserImplementation admin) {
    this.admin = admin;
  }

  public String getMSPID() {
    return mspid;
  }

  public String getCALocation() {
    return caLocation;
  }

  public void setCALocation(String caLocation) {
    this.caLocation = caLocation;
  }

  public void addPeerLocation(String name, String location) {

    peerLocations.put(name, location);
  }

  public void addOrdererLocation(String name, String location) {

    ordererLocations.put(name, location);
  }

  public void addEventHubLocation(String name, String location) {

    eventHubLocations.put(name, location);
  }

  public String getPeerLocation(String name) {
    return peerLocations.get(name);

  }

  public String getOrdererLocation(String name) {
    return ordererLocations.get(name);

  }

  public String getEventHubLocation(String name) {
    return eventHubLocations.get(name);

  }

  public Set<String> getPeerNames() {

    return Collections.unmodifiableSet(peerLocations.keySet());
  }


  public Set<String> getOrdererNames() {

    return Collections.unmodifiableSet(ordererLocations.keySet());
  }

  public Set<String> getEventHubNames() {

    return Collections.unmodifiableSet(eventHubLocations.keySet());
  }

  public HFCAClient getCAClient() {

    return caClient;
  }

  public void setCAClient(HFCAClient caClient) {

    this.caClient = caClient;
  }

  public String getName() {
    return name;
  }

  public void addUser(UserImplementation user) {
    userMap.put(user.getName(), user);
  }

  public User getUser(String name) {
    return userMap.get(name);
  }

  public Collection<String> getOrdererLocations() {
    return Collections.unmodifiableCollection(ordererLocations.values());
  }

  public Collection<String> getEventHubLocations() {
    return Collections.unmodifiableCollection(eventHubLocations.values());
  }


  public void setCAProperties(Properties caProperties) {
    this.caProperties = caProperties;
  }

  public Properties getCAProperties() {
    return caProperties;
  }


  UserImplementation getPeerAdmin() {
    return peerAdmin;
  }

  public void setPeerAdmin(UserImplementation peerAdmin) {
    this.peerAdmin = peerAdmin;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }

  public String getDomainName() {
    return domainName;
  }

  public void setCAName(String caName) {
    this.caName = caName;
  }
}
