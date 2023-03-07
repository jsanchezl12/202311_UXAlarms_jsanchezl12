import { Component, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-new-document',
  templateUrl: './new-document.component.html',
  styleUrls: ['./new-document.component.scss']
})
export class NewDocumentComponent implements OnInit {

  fileToUpload: File | null;

  // handleFileInput(files: FileList) {
  //   this.fileToUpload = files.item(0);
  // }}

  fileChange(event: any) {
    let fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      let file: File = fileList[0];
      if (file !== null) {
        this.fileToUpload = file;
      }
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}

