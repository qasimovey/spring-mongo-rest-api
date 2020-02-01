package org.qasimovey.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private  String id;
    private HashMap<String,String> ozellik;
}
