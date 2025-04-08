let myAddStudentDialog = document.getElementById("add_student");
myAddStudentDialog.addEventListener('show.bs.modal', function (event) {
    let button = event.relatedTarget;
    let link = button.getAttribute('data-bs-link');
    let form = document.getElementById("add_student_form");
    form.setAttribute('action', link);
    let name = button.getAttribute('data-bs-name');
    let age = button.getAttribute('data-bs-age');
    let rating = button.getAttribute('data-bs-rating');
    let approveButton = document.getElementById("approve_student");
    let nameEdit = document.getElementById("s_name");
    let ageEdit = document.getElementById("s_age");
    let ratingEdit = document.getElementById("s_rating");
    let idField = document.getElementById("student_id");

    let dialogTitle = myAddStudentDialog.querySelector('.modal-title');
    if (button.getAttribute('data-bs-ident') === '#add') {
        idField.value = '0';
        nameEdit.value = '';
        ageEdit.value = '0';
        ratingEdit.value = '0';
        approveButton.textContent = "Add Student";
        dialogTitle.textContent = "Add Student";
    } else {
        idField.value = button.getAttribute('data-bs-id');
        nameEdit.value = name;
        ageEdit.value = age;
        ratingEdit.value = rating;
        dialogTitle.textContent = "Edit Student";
        approveButton.textContent = "Update Student";
    }
});