import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'app-best-d-propietario',
  templateUrl: './best-d-propietario.component.html',
  styleUrls: ['./best-d-propietario.component.css']
})
export class BestDPropietarioComponent implements OnInit {

  nombre: string;
  constructor(private router: ActivatedRoute) { }

  ngOnInit(): void {
    this.router.queryParams.subscribe(params => {
      this.nombre = params['name'];
    });
  }

}
