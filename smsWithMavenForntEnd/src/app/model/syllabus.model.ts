// export class SyllabusModel {
//     syid?: number;
//     sclass?: string;
//     examCatagory?: string;
//     subjectModel?: {
//         subid?:number;
//         subName?:string;
//     };
//     pageNo?: string;
//     discription?: string;

// }


export class SyllabusModel {
    syid?: number;
    sclass?: string;
    examCatagory?: string;
    subject?: string;
    pageNo?: string;
    discription?: string;

    subjectModel?: {
      subid?: number;
      subName?: string;
    };
  }