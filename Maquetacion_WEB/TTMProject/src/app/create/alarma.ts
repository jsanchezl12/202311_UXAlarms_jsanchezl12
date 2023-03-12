export class Alarma{
  id: number;
  desc: string;
  type: string;
  alDate: string;
  alTime: string;
  frequency: string;
  sound: string;
  constructor(id: number, desc: string, type: string, alDate: string, alTime: string, frequency: string, sound: string){
    this.id = id;
    this.desc = desc;
    this.type = type;
    this.alDate = alDate;
    this.alTime = alTime;
    this.frequency = frequency;
    this.sound = sound;
  }
}
