package br.com.cod3r.iterator.tvChannel;

import java.util.Arrays;
import java.util.Iterator;

public class ChannelIterator implements Iterator<Integer> {

    private Integer[] channels;
    private int index;

    public ChannelIterator(Integer[] channels) {
        this.channels = channels;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (channels == null) {
            return false;
        }
        return channels[index] != null;
    }

    @Override
    public Integer next() {
        return channels[index++];
    }

    @Override
    public void remove() {
        Integer[] newChannels = new Integer[channels.length - 1];
        int channelToRemove = channels[index];
        int i = 0;
        for (int channel : channels) {
            if (channel != channelToRemove) {
                newChannels[i] = channel;
            }
            i++;
        }
        channels = newChannels;
    }
}
