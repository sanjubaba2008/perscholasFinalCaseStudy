//creating form content
const content = `
<form>
<div class="mb-3">
    <label for="exampleInputFirstName" class="form-label">First Name</label>
    <input type="text" class="form-control" id="exampleInputFirstName" >
    
  </div>
  <div class="mb-3">
    <label for="exampleInputLastName" class="form-label">Last Name</label>
    <input type="text" class="form-control" id="exampleInputLastName" >
    
  </div>
<div class="mb-3">
  <label for="exampleInputEmail1" class="form-label">Email address</label>
  <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
</div>

<div class="mb-3">
<label for="username" class="form-label">Username </label><br> 
<input name="username" class="form-control" id="username" pattern="[A-Za-z0-9]+">
<div class="form-text"><i>(letters and numbers only, no punctuation or special characters)</i></div>


</div>

<div class="mb-3">
  <label for="exampleInputPassword1" class="form-label">Password</label>
  <input type="password" class="form-control" id="exampleInputPassword1">
</div>
<div class="mb-3 form-check">
  <input type="checkbox" class="form-check-input" id="exampleCheck1">
  <label class="form-check-label" for="exampleCheck1">Check me out</label>
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form>

`;

const newDiv = document.createElement("div");//creating new element
newDiv.classList.add("newContainer");//adding a class name to newly created element
newDiv.setAttribute("id","myId");//adding a id name to div element
newDiv.innerHTML = content;

const main = document.querySelector("main");//selecting main element from html file
main.append(newDiv);//appending content to the html


