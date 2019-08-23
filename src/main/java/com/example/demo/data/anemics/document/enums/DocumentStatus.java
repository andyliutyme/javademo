package com.example.demo.data.anemics.document.enums;

// Upload Pending
//   -> Upload Failed

// Upload Pending
//   -> Complete

// Classification Required
//   -> Classifying
//   -> Classification Failed

// Classification Required
//   -> Classifying
//   -> Classified
//   -> Upload Failed

// Classification Required
//   -> Classifying
//   -> Classified
//   -> Complete

public enum DocumentStatus {

    // This is the default state for non classifiable documents
    UploadPending,

    // This is the default value for new documents, that require classification
    ClassificationRequired,

    // This indicates that at least 1 document has been sent for classification
    Classifying,

    // This state will be present after the document pages have all been classified
    // but the uploads have not yet completed
    Classified,

    // Used to indicate the the upload attempts to storage failed
    UploadFailed, // TODO: Implement Negative

    // If kofax, cannot classify the document, it will fail with this value
    ClassificationFailed, // TODO: Implement Negative

    // This will indicate if a document has been deleted by the user
    Deleted,  // TODO Implement Negative

    // This is set when all tasks have completed correctly
    Completed
}
