var USER_ID;

function clearLocalStorage() {
    localStorage.setItem('USER_ID', '');
}

function getUserID() {
    return localStorage.getItem('USER_ID');
}

function serialize(querySelector) {
    let result = {};
    document.querySelectorAll(querySelector)
        .forEach(function(elm) {
            switch(elm.type) {
                case 'text': result[elm.name] = elm.value
                case 'radio': if (elm.checked) result[elm.name] = elm.value
            }
        });
    return result;
}

function login() {
    let data = serialize('#form-login input[name]');
    axios.post('/user/login', data)
    .then(function({data}) {
        localStorage.setItem('USER_ID', data);
        window.open('/form-apply', '_self');
    })
    .catch(function(err) {
        console.log(err);
    });
}

function signUp() {
    let data = serialize('#form-login input[name]');
    axios.post('/user/sign-up', data)
    .then(function({data}) {
        localStorage.setItem('USER_ID', data);
        window.open('/', '_self');
    })
    .catch(function(err) {
        console.log(err);
    });
}

function apply() {
    let data = serialize('#form-apply input[name]');
    data.id = getUserID();
    data.user = {
        id: getUserID()
    };
    axios.post('/user/apply', data)
    .then(function({data}) {
        localStorage.setItem('USER_ID', data);
        window.open('/success', '_self');
    })
    .catch(function(err) {
        console.log(err);
    });
}

function show(id) {
    console.log(id);
}