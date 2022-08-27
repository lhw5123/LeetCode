/* 
This is Sample Program for generating the Signature 

Token Sign Creation  
*/

var crypto = require("crypto"),
  fs = require("fs");
var requrl, signhdr, basestring, signer, signres, timestamp;

/* Private key for generating the signature */
var key = fs.readFileSync("/Users/hevin/Downloads/igloo.pem", "utf8");
console.log('private key', key);

/* Request Payload */
var reqmsg = {
  grant_type: "client_credentials",
  scope: "motors",
  client_id: "dd11975b152b44d1b7158725662b31c9",
  client_secret: "b8d17b620dae4561b35c11d7103091d2",
};
/* Generate epoch timestamp */
// const now = new Date();
// timestamp = Math.round(now.getTime() / 1000);
timestamp = 1653386934
console.log("X-MB-Timestamp: " + timestamp);

/* Request URL for Base string */
requrl = "https://staging.api.maybank.com/U/api/oauth2/v4/clientcred/token";

/* Signature Base String Construction  */
signhdr = "X-MB-Timestamp=" + timestamp + ";";
basestring =
  "POST;" + encodeURIComponent(requrl) + ";" + signhdr + JSON.stringify(reqmsg);
console.log("SingatureBasestring: " + basestring);

/* Signature Constructure */
signer = crypto.createSign("RSA-SHA256");
signer.update(basestring);
signres = signer.sign(key, "base64");
console.log("signature with rsa-sha256 is: " + signres);

function verifySignature(timestamp, signres) {
  /* 
This is Sample Program for Verfication of the Signature 

*/
  var crypto = require("crypto"),
    fs = require("fs");

  /* Public key for signature verification */
  var key = fs.readFileSync("/Users/hevin/Downloads/igloo.pub", "utf8");
  var requrl, signhdr, basestring;

  /* Request Payload */
  var reqmsg = {
    grant_type: "client_credentials",
    scope: "motors",
    client_id: "dd11975b152b44d1b7158725662b31c9",
    client_secret: "b8d17b620dae4561b35c11d7103091d2",
  };

  /* Request URL for Base string */
  requrl = "https://staging.api.maybank.com/U/api/oauth2/v4/clientcred/token";

  /* Generate epoch timestamp */
  // timestamp = "1627820686";
  console.log("X-MB-Timestamp: " + timestamp);

  /* Signature value */
  // var signvalue =
  //   "O0pehWJQ+dX7IviDCT0OKmt72IxKGoVcxWpCmaxVTfDeJQJ4VhqD6xpzMFzFXgcMVPms825I/8sst5zTgL/Qfd4nAIBgII1+3b1iEKIi/jmgMICEu2LqPpiKseDuGEWQXHJaDd1bvIIgH0++NiMknh58QGRV9SRkOzrxU6pn75W6QVepg3OWcBqMt60VB14fiDX12jIlwlJk4SDJY1a8ZnYySOSdJGqByZ6i9AsTOhx9OEFZWkYkt62iEdr2n88mQuZaBhxJOSk3If6A51AspfkTXaO9RVi+0HrPIeb8Ldai8QH8q/OnBCmFOJ6j0PVybu/HlQZABgtqeIAyITaLsQ==";
  var signvalue = signres;

  /* Signature Base String Construction  */
  signhdr = "X-MB-Timestamp=" + timestamp + ";";
  basestring =
    "POST;" +
    encodeURIComponent(requrl) +
    ";" +
    signhdr +
    JSON.stringify(reqmsg);

  /* Signature Verification */
  var verifier = crypto.createVerify("RSA-SHA256");
  verifier.update(basestring);
  var verifyres = verifier.verify(key, signvalue, "base64");

  /* Result : for Success : value is true ; Failed : false */
  console.log("signature verification result: " + verifyres);
}

verifySignature(timestamp, signres);
