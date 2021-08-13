package com.demo.exceltodb.service;

import com.demo.exceltodb.entity.Library;
import com.demo.exceltodb.excelHelper.ExcelDownload;
import com.demo.exceltodb.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    LibraryRepository libraryRepository;

    public ByteArrayInputStream load(){
        List<Library> libraries = libraryRepository.findAll();
        ByteArrayInputStream in = ExcelDownload.downloadAsExcel(libraries);
        return in;
    }
}
