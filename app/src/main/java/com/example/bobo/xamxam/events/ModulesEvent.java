package com.example.bobo.xamxam.events;

import com.example.bobo.xamxam.beans.Module;

import java.util.List;

public class ModulesEvent {

    private List<Module> modules;


    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public ModulesEvent(List<Module> modules) {
        this.modules = modules;
    }
}
