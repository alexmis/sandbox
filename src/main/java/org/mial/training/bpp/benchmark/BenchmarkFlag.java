package org.mial.training.bpp.benchmark;

public class BenchmarkFlag implements BenchmarkFlagMBean {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
