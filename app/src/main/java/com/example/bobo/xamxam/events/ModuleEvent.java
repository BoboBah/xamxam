package com.example.bobo.xamxam.events;

import com.example.bobo.xamxam.beans.Module;

public class ModuleEvent {

    private Module module;


    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ModuleEvent(Module module) {
        this.module = module;
    }
}
