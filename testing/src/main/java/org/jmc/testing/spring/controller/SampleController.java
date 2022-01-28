package org.jmc.testing.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/samples")
public class SampleController {

  static final int ID = 1;
  static final String NAME = "sample-name";

  record SampleResponse(int id, String name) {}

  @GetMapping()
  public ResponseEntity<SampleResponse> getSample() {

    return ResponseEntity.ok(new SampleResponse(ID, NAME));
  }
}
