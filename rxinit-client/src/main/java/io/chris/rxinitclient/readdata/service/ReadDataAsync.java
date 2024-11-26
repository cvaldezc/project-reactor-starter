package io.chris.rxinitclient.readdata.service;

import io.chris.rxinitclient.readdata.model.Record;

import java.util.Collection;

public interface ReadDataAsync {

    Collection<Record> getAllRecords();
}
