package com.sme.poc.service;

import java.util.List;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v1.model.WorkspaceCollection;
import com.ibm.watson.discovery.v1.Discovery;
import com.sme.poc.model.SMEs;

public class SMEService {

    // private void watson() {

    //     // IamAuthenticator authenticator = new
    //     // IamAuthenticator("tzPbjce1rRbFaduanzKuGoDeAnuClsMqqR22E3WgR894");
    //     Discovery discovery = new Discovery("2019-04-30");

    //     Response<WorkspaceCollection> response = discovery.listWorkspaces().execute();
    //     WorkspaceCollection collection = response.getResult();
    //     System.out.println("My workspaces: " + collection.getWorkspaces());
    // }

    // List<SMEs> findByJob_titleContaining(String job_title);
    // List<SMEs> findBySkills(Array skills);
    // List<SMEs> findbyName(String name);

}
