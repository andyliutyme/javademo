package com.example.demo.data.anemics.document.enums;

public enum DocumentPageStatus {
    // <summary>
    // This is the default value for new pages, that require classification
    // </summary>
    ClassificationRequired,

    // <summary>
    // This is the value to show that classification has failed
    // </summary>
    ClassificationFailed,

    // <summary>
    // This is the default value for new pages, that do not require classification.
    // It is also used, when classification has succeeded
    // </summary>
    UploadRequired,

    // <summary>
    // This is the value that will be used when the updload has failed.
    // This field is not meant to be used in queries for job manager or tasks.
    // </summary>
    UploadFailed,

    // <summary>
    // This is the value, that will be set when the document resides in blockchain
    // </summary>
    UploadCompleted,

    // <summary>
    // This is the value, that will be set when the page is set to deleted
    // </summary>
    Deleted
}
